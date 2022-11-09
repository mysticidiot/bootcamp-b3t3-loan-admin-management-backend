package com.b3t3.loanAdminManagement.serviceTest;

import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;
import com.b3t3.loanAdminManagement.dao.Item_Master_dao;
import com.b3t3.loanAdminManagement.model.Item_Master;
import com.b3t3.loanAdminManagement.service.Items_Master_service_impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemMasterServiceTest {

	//Class to test the item service
	
    @Mock
    Item_Master_dao repository;

    @InjectMocks
    Items_Master_service_impl itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void addNewItem() throws IdAlreadyExistsException {
        Item_Master newItem = new Item_Master("CR01", "Car", 'Y', "Steel",
                "Vehicle", (long) 1000000);
        when(repository.findById(anyString())).thenReturn(Optional.of(newItem));
        String response = itemService.addItem(newItem);
        assert(response.equals("Item Added Successfully!"));
        Optional<Item_Master> found = repository.findById(newItem.getItem_id());
        assert(found.isPresent());
        assert(found.get().getItem_id().equals(newItem.getItem_id()));
    }

    @Test
    public void updateItemCheck(){
        Item_Master newItem = new Item_Master("CR01", "Car", 'Y', "Steel",
                "Vehicle", (long) 1000000);
        String response;
        when(repository.findById(anyString())).thenReturn(Optional.of(newItem));
        try {
            newItem.setItem_description("Jet");
            response = itemService.updateItem(newItem);
            assert(response.toLowerCase().contains("updated"));
        }catch (Exception e) {
            assert(e.getMessage().toLowerCase().contains("does not exist"));
        }
    }

    @Test
    public void deleteItemCheck(){
        Item_Master newItem = new Item_Master("CR01", "Car", 'Y', "Steel",
                "Vehicle", (long) 1000000);
        String response;
        when(repository.findById(anyString())).thenReturn(Optional.of(newItem));
        try {
            response = itemService.deleteItem(newItem.getItem_id());
            assert(response.toLowerCase().contains("deleted"));
        }catch (Exception e) {
            assert(e.getMessage().toLowerCase().contains("does not exist"));
        }
    }

    @Test
    public void deleteItemWhenDoesNotExist(){
        Item_Master newItem = new Item_Master("CR01", "Car", 'Y', "Steel",
                "Vehicle", 1000000L);
        when(repository.findById(anyString())).thenReturn(Optional.of(newItem));
        assertThrows(IdDoesNotExistException.class, () -> {
            itemService.deleteItem(newItem.getItem_id());
        });
    }

    @Test
    public void updateItemWhenDoesNotExist(){
        Item_Master newItem = new Item_Master("CR01", "Car", 'Y', "Steel",
                "Vehicle", 1000000L);
        when(repository.findById(anyString())).thenReturn(Optional.of(newItem));
        assertThrows(IdDoesNotExistException.class, () -> {
            itemService.updateItem(newItem);
        });
    }

}
