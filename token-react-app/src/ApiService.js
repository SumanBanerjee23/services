import axios from 'axios';

class ApiService {
  constructor() {
    this.api = axios.create("http://localhost:8080/token");
  }

  async generateToken(data) {
    try {
      const response = await this.api.post('/generate', data, {
        headers: {
          'Content-Type': 'application/json',
        },
    });
      return response.data;
    } catch (error) {
      throw error;
    }
  }

  async validateToken(inputString) {
    try {
      const response = await this.api.post('/validate', { token: inputString });
      return response.data;
    } catch (error) {
      throw error;
    }
  }
}

export default ApiService;
