package handler;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.shoppingcart.model.User;

@Component
public class RegistrationHandler {

	public User initFlow(){
		return new User();
	}

	public String validateDetails(User user,MessageContext messageContext){
		String status = "success";
		if(user.getId().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"id").defaultText("UserId cannot be Empty").build());
			status = "failure";
		}
		if(user.getName().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"name").defaultText("Name cannot be Empty").build());
			status = "failure";
		}
		if(user.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"password").defaultText("Password cannot be Empty").build());
			status = "failure";
		}
	
		if(user.getEmail().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"email").defaultText("Email cannot be Empty").build());
			status = "failure";
		}
		if(user.getMob().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"mobile").defaultText("Mobile cannot be Empty").build());
			status = "failure";
		}
		if(user.getAdd().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"address").defaultText("Address cannot be Empty").build());
			status = "failure";
		}
		
		return status;
	}
	
}
