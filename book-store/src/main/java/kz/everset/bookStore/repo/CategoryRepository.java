package kz.everset.bookStore.repo;

import kz.everset.bookStore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
