package be.multimedi.restoapp.repository;

import be.multimedi.restoapp.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
