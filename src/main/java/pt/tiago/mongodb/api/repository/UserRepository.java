package pt.tiago.mongodb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pt.tiago.mongodb.api.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
