package acme.features.inventor.itemQuantity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.ItemQuantity;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemQuantityController extends AbstractController<Inventor,ItemQuantity>{

    @Autowired
    protected InventorItemQuantityComponentsListService componentsListService;
    
    @Autowired
    protected InventorItemQuantityToolsListService toolsListService;
    
    @Autowired
    protected InventorItemQuantityCreateService createService;

    @PostConstruct
    protected void initialise() {
        super.addCommand("list-components","list", this.componentsListService);
        super.addCommand("list-tools","list", this.toolsListService);
        super.addCommand("create", this.createService);
    }

}
