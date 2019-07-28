<template>
<div>
  <div class="row">
    <div class="col-sm">
      <div v-if="errorMessage" class="alert alert-danger" role="alert">
        {{errorMessage}}
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-sm">
        <div class="form-group" v-if="updateMode">
          <label for="name">Id</label>
          <input
            v-model="foodProduct.id"
            type="text"
            class="form-control"
            id="id"
            placeholder="Id"
            required
          >
        </div>
        <div class="form-group">
          <label for="name">Name</label>
          <input
            v-model="foodProduct.name"
            type="text"
            class="form-control"
            id="name"
            placeholder="Name"
            required
          >
        </div>
        <div class="form-group">
          <label for="description">description</label>
          <input
            v-model="foodProduct.description"
            type="text"
            class="form-control"
            id="description"
            placeholder="Description"
            required
          >
        </div>
        <div class="form-group">
          <label for="price">price</label>
          <input
            v-model="foodProduct.price"
            type="text"
            class="form-control"
            id="price"
            placeholder="Price"
            required
          >
        </div>
        <div class="form-group">
          <label for="image">image</label>
          <input
            v-model="foodProduct.image"
            type="text"
            class="form-control"
            id="image"
            placeholder="Image"
            required
          >
        </div>
        <button class="btn btn-primary" v-on:click="save">{{updateMode ? 'Update' : 'Save'}}</button>
      </div>
    </div>
</div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'
import { FoodProduct } from '../entities/FoodProduct'

@Component
export default class FoodProductForm extends Vue {
  @Prop() private readonly type!: string
  @Prop({ default: () => FoodProduct.emptyFoodProduct() }) private readonly foodProduct!: FoodProduct

  private repeatPassword:string = ''
  private errorMessage:string = ''

  save () {
    if (this.isValid(this.foodProduct)) {
      this.$emit('foodProductFilled', this.foodProduct)
    }
  }

  isValid (foodProduct:FoodProduct) {
    if (foodProduct.name === '') {
      this.errorMessage = 'Name is required'

      return false
    }

    if (foodProduct.description === '') {
      this.errorMessage = 'Description is required'

      return false
    }

    if (foodProduct.price === 0.0) {
      this.errorMessage = 'Price is required'

      return false
    }

    if (foodProduct.image === '') {
      this.errorMessage = 'Image is required'

      return false
    }

    return true
  }

  get updateMode () {
    return this.type === 'update'
  }
}
</script>
