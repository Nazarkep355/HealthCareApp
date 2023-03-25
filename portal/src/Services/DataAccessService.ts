import User from "../models/User";
import axios from 'axios';
import Doctor from "src/models/Doctor";
import Analyse from "src/models/Analyse";
import AnalyseRecord from "src/models/AnalyseRecord";
import DoctorRecord from "src/models/DoctorRecord";
const apiUrl =  'http://localhost:1488/'; // import.meta.env.API;

export const GetUser = async (email: string, password: string): Promise<User> => {
    const response = await axios.post<User>(`${apiUrl}login?email=${email}&password=${password}`);
    return response.data;
};

export const GetAllDoctors = async (): Promise<Doctor[]> => {
    const response = await axios.get(`${apiUrl}doctors`);
    return response.data.content;
};

export const GetAllAnalyses = async (): Promise<Analyse[]> => {
    const response = await axios.get(`${apiUrl}analyses/subjects`);
    return response.data.content;
};

export const GetAllAnalysesbyUser = async (userId: number): Promise<AnalyseRecord[]> => {
    const response = await axios.get(`${apiUrl}analyses/user/${userId}`);
    return response.data.content;
};

export const GetAllRecordByUser = async (userId: number): Promise<DoctorRecord[]> => {
    const response = await axios.get(`${apiUrl}records/${userId}`);
    return response.data.content;
};

export const RecordToDoctor = async (date: string, userId: number, doctorId: number, topicId: number): Promise<void> => {
    const response = await axios.post(`${apiUrl}records?date=${date}&user_id=${userId}&doctor_id=${doctorId}&topicId=${topicId}`);
    return;
};