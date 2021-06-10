package be.multimedi.restoapp.service;

import be.multimedi.restoapp.model.MenuItem;
import be.multimedi.restoapp.repository.MenuItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {
    private MenuItemRepository menuItemRepository;

    @Override
    public void register(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }
}
