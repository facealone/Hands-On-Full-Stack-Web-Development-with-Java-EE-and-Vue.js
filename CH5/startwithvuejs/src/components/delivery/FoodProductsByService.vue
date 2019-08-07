<template>
  <div>
    <h2 class="text-center">Food Products</h2>
    <div class="row mt-2">
      <div class="col-sm">
        <table class="table  table-dark">
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Description</th>
              <th>Price</th>
              <th>Image</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="foodProduct in foodProducts" v-bind:key="foodProduct.id">
              <td>{{foodProduct.id}}</td>
              <td>{{foodProduct.name}}</td>
              <td>{{foodProduct.description}}</td>
              <td>{{foodProduct.price}}</td>
              <td>{{foodProduct.image}}</td>
            </tr>
          </tbody>
        </table>
    </div>
    </div>
  </div>
</template>

<script lang="ts">
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import { Component, Vue, Prop } from 'vue-property-decorator'
import { FoodProduct } from '../../entities/FoodProduct'
import { FoodService } from '../../entities/FoodService'

@Component
export default class FoodProductsByService extends Vue {
  @Prop() private readonly foodService!: string
  foodProducts:FoodProduct[] = []
  foodServiceData: FoodService = FoodService.emptyFoodService()

  // lifecycle hook
  mounted () {
    this.getFoodProducts(this.foodService)
  }

  getFoodProducts (foodService: string) {
    this.foodProducts = this.$store.getters.getFoodProductByFoodService(foodService)
    this.foodServiceData = this.$store.getters.getFoodServiceByEmail(
      foodService
    )
  }
}
</script>
