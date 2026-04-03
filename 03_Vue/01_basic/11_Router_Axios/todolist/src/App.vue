<template>
  <div class="container">
    <Header></Header>
    <RouterView></RouterView>
  </div>
</template>

<script setup>
import { RouterView } from 'vue-router';
import Header from './components/Header.vue';
// import todoLists from '../db.json';
import { computed, onMounted, provide, reactive } from 'vue';
import axios from 'axios';

// axios로 todolist 조회하기
const BASEURI = '/api/todos';

// 1. todo list 조회하기
const state = reactive({
  todoLists: [],
});

const fetchTodoList = async () => {
  try {
    const response = await axios.get(BASEURI);

    if (response.status === 200) {
      console.log('response.data: ', response.data);
      state.todoLists = response.data;
    } else {
      alert('데이터 조회 실패');
    }
  } catch (err) {
    alert('에러 발생: ' + err);
  }
};

// 토글 조작
const toggleDone = (id) => {
  let index = state.todoLists.findIndex((item) => item.id === id);

  // 완료 상태 수정
  state.todoLists[index].done = !state.todoLists[index].done;
};

// 2. todo 추가하기
// const addTodo = ({ todo, desc }) => {
//   state.todoLists.push({ id: Date.now(), todo, desc, done: false });
// };

const addTodo = async ({ todo, desc }) => {
  const payload = { todo, desc };
  const response = await axios.post(BASEURI, payload);

  if (response.status === 201) {
    state.todoLists.push({ id: Date.now(), todo, desc, done: false });
  } else {
    alert('Todo 추가 실패');
  }
};

// todoList가 변경되면 inject한 컴포넌트도 재렌더링되도록
provide(
  'todoList',
  computed(() => state.todoLists),
);

provide('actions', { toggleDone, addTodo });

// DOM이 준비된 후에 초기 데이터를 준비
onMounted(() => {
  fetchTodoList(); // 데이터 준비용
});
</script>

<style scoped></style>
