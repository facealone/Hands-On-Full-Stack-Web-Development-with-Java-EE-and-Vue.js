<template>
  <div>
    <h2 class="text-center">Food Products</h2>
    <div class="row">
      <div class="col-sm">
       <router-link :to="{ name: 'food_product_new', params: { foodService: foodService }}" class="btn btn-primary">Create New FoodProduct</router-link>
      </div>
    </div>
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
              <td><router-link  :to="{ name: 'food_product_update', params: { id: foodProduct.id }}">Update</router-link></td>
              <td><a v-on:click="remove(foodProduct)" href="#">Delete</a></td>
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

@Component
export default class FoodProductList extends Vue {
  @Prop() private readonly foodService!: string
  foodProducts:FoodProduct[] = []

  // lifecycle hook
  mounted () {
    this.getFoodProducts(this.foodService)
  }

  getFoodProducts (foodService: string) {
    this.foodProducts = this.$store.getters.getFoodProductByFoodService(foodService)
  }

  remove (foodProductToRemove:FoodProduct) {
    this.$store.commit('removeFoodProduct', foodProductToRemove)
  }
}
</script>
