package per.czt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import per.czt.pojo.Profession;
import per.czt.pojo.User;
import per.czt.service.ProfessionService;


@Controller
@RequestMapping("/profession")
public class ProfessionController {
	@Autowired
	private ProfessionService professionService;
	@RequestMapping("/showAll")
	public String showAllProfessions(Model model) {
		List<Profession> professions=professionService.searchAllProfessions();
		model.addAttribute("professionList", professions);
		System.out.println("professionList:"+professions);
		for(Profession profession:professions) {
			System.out.println("profession:"+profession);
			System.out.println("profession_id:"+profession.getProfession_id());
			System.out.println("profession_name:"+profession.getProfession_name());
			System.out.println("profession_users:"+profession.getUsers());
	
			for(User user:profession.getUsers()) {
				System.out.println("user_id:"+user.getUser_id());
				System.out.println("user_account:"+user.getUser_account());
				System.out.println("user_profession:"+user.getProfession());
				System.out.println("user_profession_id:"+user.getProfession().getProfession_id());
				System.out.println("user_profession_name:"+user.getProfession().getProfession_name());
			}
			System.out.println();
		}
		
		return "professionList";
	}

}
