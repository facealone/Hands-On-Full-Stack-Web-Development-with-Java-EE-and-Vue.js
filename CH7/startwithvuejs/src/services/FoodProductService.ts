import axios from 'axios'
import { FoodProduct } from '../entities/FoodProduct'
import { User } from '../entities/User'

export class FoodProductService {
  static create (foodProduct: FoodProduct) {
    return axios.post<FoodProduct>(`http://localhost:8080/StartWithJEE8-web/api/foodproducts`, foodProduct)
  }

  static update (foodProduct: FoodProduct) {
    return axios.put<FoodProduct>(`http://localhost:8080/StartWithJEE8-web/api/foodproducts`, foodProduct)
  }

  static deActivate (foodProduct: FoodProduct) {
    return axios.delete<FoodProduct>(`http://localhost:8080/StartWithJEE8-web/api/foodproducts/${foodProduct.id}`)
  }

  static getByFoodService (foodService: string, page:number, pageSize:number) {
    return axios.get<Array<FoodProduct>>(`http://localhost:8080/StartWithJEE8-web/api/foodproducts?foodService=${foodService}&page=${page}&pageSize=${pageSize}`)
  }
}
