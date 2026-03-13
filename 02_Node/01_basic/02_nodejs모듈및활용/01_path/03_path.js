const path = require('path');

// 파일 확장자
const ext = path.extname(__filename);
console.log('확장자: ', ext);

const parsedPath = path.parse(__filename);
console.log(`parsedPath: `, parsedPath);
