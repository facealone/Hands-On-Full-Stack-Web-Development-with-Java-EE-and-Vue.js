
export class FoodService {
    email: string = ''
    name: string = ''
    address: string = ''
    foodType: string = ''
    deliveryFee: number = 0.0
    password: string = ''

    static emptyFoodService () {
      let foodService:FoodService = new FoodService()

      return foodService
    }

    static newFoodService (email: string, name: string, address: string, foodType: string, deliveryFee: number, password: string) {
      let foodService:FoodService = new FoodService()

      foodService.email = email
      foodService.name = name
      foodService.address = address
      foodService.foodType = foodType
      foodService.deliveryFee = deliveryFee
      foodService.password = password

      return foodService
    }

    copyFoodService (foodServiceToCopy: FoodService) {
      this.email = foodServiceToCopy.email
      this.name = foodServiceToCopy.name
      this.address = foodServiceToCopy.address
      this.foodType = foodServiceToCopy.foodType
      this.deliveryFee = foodServiceToCopy.deliveryFee
      this.password = foodServiceToCopy.password
    }
}
