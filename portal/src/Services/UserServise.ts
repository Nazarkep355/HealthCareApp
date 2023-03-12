import User from "../Models/User";
import axios from 'axios';
const apiUrl = import.meta.env.BASE_URL;

export const GetUser = async (email: string, password: string): Promise<User> => {
   const response = await axios.get<User>(apiUrl + 'login', {
        params: {
            email: email,
            password: password
        }
    })
    return response.data;
};

