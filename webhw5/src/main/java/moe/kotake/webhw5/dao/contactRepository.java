package moe.kotake.webhw5.dao;

import moe.kotake.webhw5.contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface contactRepository extends JpaRepository<contact,Long>{
    List<contact> findByTel(String tel);
    void deleteById(Long id);
}
