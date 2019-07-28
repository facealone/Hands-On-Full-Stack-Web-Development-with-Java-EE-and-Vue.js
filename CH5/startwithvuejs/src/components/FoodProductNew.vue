<template>
  <div>
    <FoodProductForm v-on:foodProductFilled="save($event)"></FoodProductForm>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import FoodProductForm from '@/components/FoodProductForm.vue'
import { FoodProduct } from '../entities/FoodProduct'

@Component({
  components: {
    FoodProductForm
  }
})
export default class FoodProductNew extends Vue {
  save (foodProduct:FoodProduct) {
    this.$store.commit('saveFoodProduct', foodProduct)

    this.$router.push({ name: 'food_product_list' })
  }
}
</script>
