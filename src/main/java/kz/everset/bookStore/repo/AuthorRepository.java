package kz.everset.bookStore.repo;

import kz.everset.bookStore.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
