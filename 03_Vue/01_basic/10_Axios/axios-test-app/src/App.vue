<template>
  <div>
    <button @click="requestAxios">Axios 버튼</button>
    <button @click="requestFetch">Fetch 버튼</button>
  </div>
</template>

<script setup>
import axios from 'axios';

const url = '/api/todos';

// axios.get()은 비동기 함수이기 때문에 결과를 바로 반환하지 않고 Promise 객체를 반환
// const response = axios.get(url);
// console.log('response', response);

const requestAxios = () => {
  axios.get(url).then((response) => {
    console.log(`[Axios] 응답 객체: `, response);
    console.log(`[Axios] 응답 객체: `, response.data);
  });
};

const requestFetch = () => {
  fetch(url)
    .then((response) => response.json()) // 역직렬화
    .then((data) => {
      console.log(`[Fetch] 응답: `, data);
    });
};
</script>

<style scoped></style>
