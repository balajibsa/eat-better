package au.balaji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.balaji.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

}
