import User from "../models/User";
import axios from 'axios';
const apiUrl =  'http://localhost:1488/'; // import.meta.env.API;

export const GetUser = async (email: string, password: string): Promise<User> => {
    const response = await axios.post<User>(`${apiUrl}login?email=${email}&password=${password}`);
    return response.data;
};

