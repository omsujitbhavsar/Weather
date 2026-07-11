import api from "../api/axios";

export const login = (username, password) => {
    return api.post("/auth/login", {
        username,
        password,
    });
};

export const register = (username, password) => {
    return api.post("/auth/register",{
    username,
    password,
    });
};