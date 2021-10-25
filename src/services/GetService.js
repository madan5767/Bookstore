import axios from "axios";
export const sendPostRequest = async (url, postData) => {
  try {
    const response = await axios.post(`http://localhost:8082/${url}`, postData);
    const data = await response.data;
    return {
      data: data,
      error: undefined,
      loading: false,
    };
  } catch (error) {
    return {
      data: undefined,
      error: error.message,
      loading: false,
    };
  }
};