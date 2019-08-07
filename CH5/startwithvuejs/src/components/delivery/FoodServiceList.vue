<template>
  <div>
    <h2 class="text-center">Food Services</h2>

    <div class="row">
      <div class="col-sm">
        <div class="form-group">
          <label for="foodType">Type of Food</label>
          <select class="custom-select" id="foodType" v-model="foodType" v-on:change="filter">
            <option selected value="ALL">ALL</option>
            <option value="PIZZA">PIZZA</option>
            <option value="CHINESE">CHINESE</option>
          </select>
        </div>
      </div>
    </div>
    <div class="row mt-2">
      <div class="col-sm">
        <table class="table  table-dark">
          <thead>
            <tr>
              <th></th>
              <th>Name</th>
              <th>Address</th>
              <th>Food Type</th>
              <th>Delivery Fee</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="foodService in foodServices" v-bind:key="foodService.email">
              <td>{{foodService.image}}</td>
              <td>{{foodService.name}}</td>
              <td>{{foodService.address}}</td>
              <td>{{foodService.foodType}}</td>
              <td>{{foodService.deliveryFee}}</td>
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
import { FoodService } from '../../entities/FoodService'

@Component
export default class FoodServiceList extends Vue {
  @Prop() private readonly deliveryEmail!: string
  foodServices:FoodService[] = []
  foodType:string = 'ALL'

  // lifecycle hook
  mounted () {
    this.getFoodServices(this.foodType)
  }

  filter () {
    this.getFoodServices(this.foodType)
  }

  getFoodServices (foodType:string) {
    this.foodServices = this.$store.getters.getFoodServiceByFoodType(foodType)
  }
}
</script>
