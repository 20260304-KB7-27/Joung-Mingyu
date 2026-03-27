<template>
  <div class="row mb-3">
    <div class="col">
      <div class="input-group">
        <input
          type="text"
          class="form-control"
          placeholder="할일을 여기에 입력!"
          v-model.trim="todo"
          @keyup.enter.exact="addTodo"
          @keyup.ctrl.enter.exact="addTodo"
        />
        <span class="btn btn-primary input-group-addon" @click="addTodo"
          >추가</span
        >
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const todo = ref('');
const emit = defineEmits(['add']);

const addTodo = (e) => {
  if (todo.value === '') return;

  emit('add', {
    id: new Date().getTime(),
    todo: todo.value,
    completed: e.ctrlKey ? true : false,
  });

  todo.value = '';
};
</script>
