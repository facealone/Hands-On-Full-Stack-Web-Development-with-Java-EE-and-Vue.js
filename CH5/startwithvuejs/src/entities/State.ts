import { FoodProduct } from './FoodProduct'
import { FoodService } from './FoodService'
import { Cart } from './Cart';

export class State {
    foodProducts: FoodProduct[] = [];
    foodServices: FoodService[] = [];
    cart: Cart = Cart.emptyCart()
    currentFoodServiceLoggedIn: string = '';
    currentDeliveryEmail: string = '';
}