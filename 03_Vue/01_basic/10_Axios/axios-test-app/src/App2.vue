<template>
  <div>
    <button @click="requestAxios">Axios 버튼</button>
  </div>
</template>

<script setup>
import axios from 'axios';

const url = '/api/todos';

const data = {
  todo: 'Await 윗몸일으키기',
  desc: '너무 빠르지 않게...',
};

// const requestAxios = () => {
//   axios.post(url, data).then((response) => {
//     console.log(`[Axios] 응답 데이터: `, response.data);
//   });
// };

// async await 적용
const requestAxios = async () => {
  const response = await axios.post(url, data);
  console.log(`[Axios] 응답 데이터: `, response.data);
};
</script>

<style scoped></style>
