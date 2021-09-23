import axios from 'axios'
import store from '@/store/store'

export default () => {
  return axios.create({
    baseURL: "http://localhost:8081/",
    headers: {
      token: `${store.state.token}`,
      signature: `${store.state.signature}`
    }
  })
}