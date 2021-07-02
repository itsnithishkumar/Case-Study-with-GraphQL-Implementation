package com.nithish.cartservicegraphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.nithish.cartservicegraphql.entity.Cart;
import com.nithish.cartservicegraphql.entity.Items;
import com.nithish.cartservicegraphql.respository.CartRepository;

@Service
public class CartServiceImplementation implements GraphQLQueryResolver, GraphQLMutationResolver {
	
	@Autowired
	CartRepository cartRepository;
	
    public Cart addItemToCart(@RequestBody Items item,@RequestParam String cartId)
    {	
    		Cart cart = cartRepository.findByCartId(cartId);    

            if(cart!=null){
                List<Items> items = cart.getItems();
                items.add(item);
                cart.setItems(items);
                cart.setCartTotal(cart.getCartTotal() + item.getProduct().getPrice()*item.getQuantity());
            }else{
                List<Items> items = new ArrayList<>();
                items.add(item);

                cart = new Cart();
                cart.setCartId(cartId);
                cart.setItems(items);
                cart.setCartTotal(item.getProduct().getPrice()*item.getQuantity());
            }

            Cart updatedCart = cartRepository.save(cart);

            return updatedCart;

        
    }

    //Get Cart By User Id

    
    public String getCartByUserId(@RequestParam String cartId){
        
            Cart cart = this.cartRepository.findByCartId(cartId);
            if(cart != null){
                return "Your Cart is" + cart;
            }else{
                return "Your Cart is empty";
            }
        
            
    }

    //Update Item in Cart

    
    public Cart updateItemInCart(@RequestBody Items item,@RequestParam String cartId)
    {
       

            Cart cart = cartRepository.findByCartId(cartId);
            List<Items> items = cart.getItems();

            Items previousItem = new Items();



            for (Items value : items) {
                if (value.getProduct().getProductId().equals(item.getProduct().getProductId())) {

                    previousItem.getProduct().setProductId(value.getProduct().getProductId());
                    previousItem.getProduct().setPrice(value.getProduct().getPrice());
                    previousItem.setQuantity(value.getQuantity());

                    value.getProduct().setPrice(item.getProduct().getPrice());
                    value.setQuantity(item.getQuantity());
                    break;

                }
            }

            cart.setItems(items);

            double price = cart.getCartTotal()
                    - (previousItem.getProduct().getPrice()*previousItem.getQuantity())
                    + (item.getProduct().getPrice()*item.getQuantity());

            cart.setCartTotal(price);
            Cart updatedCart  = cartRepository.save(cart);

            return  updatedCart;

        
    }

    //Delete Item from Cart

    
    public Cart deleteItemFromCart(@RequestBody Items item,@RequestParam String cartId)
    {
       
            Cart cart = this.cartRepository.findByCartId(cartId);
            List<Items> items = cart.getItems();


            items.remove(item);
            cart.setItems(items);
            cart.setCartTotal(cart.getCartTotal()-item.getProduct().getPrice()*item.getQuantity());

            Cart cartAfterDeleted = this.cartRepository.save(cart);

            return cartAfterDeleted;
        
            
    }

   
    public Cart deleteCart(@RequestParam String cartId){
        
            Cart cart = this.cartRepository.findByCartId(cartId);
            cart.setCartTotal(0);
            List<Items> items = new ArrayList<>();
            cart.setItems(items);
            cartRepository.save(cart);
            return cart;
        }
   
	
	

}
