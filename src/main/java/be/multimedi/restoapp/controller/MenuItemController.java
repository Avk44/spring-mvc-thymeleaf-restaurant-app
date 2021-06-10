package be.multimedi.restoapp.controller;

import be.multimedi.restoapp.service.MenuItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class MenuItemController {
    private MenuItemService menuItemService;
}
