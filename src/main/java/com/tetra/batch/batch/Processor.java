package com.tetra.batch.batch;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tetra.batch.entity.Users;
import com.tetra.batch.repository.UsersRepository;

@Component
public class Processor implements ItemProcessor<Users, Users> {

	@Autowired
	private UsersRepository userRepo;

	@Override
	public Users process(Users user) throws Exception {
		Optional<Users> userFromDb = userRepo.findById(user.getUserId());
		if(userFromDb.isPresent()) {
			user.setAmount(user.getAmount().add(userFromDb.get().getAmount()));
		}
		return user;
	}

}
