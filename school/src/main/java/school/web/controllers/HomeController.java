package school.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import school.constants.enumuration.AuthorityEnum;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController extends BaseController {


    protected HomeController(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(Principal principal, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> authorities = getAuthorities(authentication);
        model.addAttribute("authorities", authorities);
        String username = principal.getName();
        if (authorities.contains(AuthorityEnum.TEACHER.name())) {
            return redirect("/teachers/home/" + username);
        }
        if (authorities.contains(AuthorityEnum.ADMIN.name())) {
            return redirect("/admin/home");
        }
        if (authorities.contains(AuthorityEnum.STUDENT.name())) {
            return redirect("/students/home/" + username);
        }
        return "home-user";
    }

    private List<String> getAuthorities(Authentication authentication) {
        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }
}
