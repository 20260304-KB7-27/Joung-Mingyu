import axios from 'axios';

const instance = axios.create({
  baseURL: 'api/',

  /*
    axios 요청에 대해 공통된 설정들을 구성
  */
  // header
  // headers: {
  // 공통 헤더들
  //   Authorization: "Bearer + ..."
  // }
  // timeout
});

export default instance;
