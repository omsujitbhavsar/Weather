import api from "../api/axios";

export const getWeather = (city) => {

    return api.get(`/api/weather/${city}`, {
        headers: {
            Authorization: `Bearer ${localStorage.getItem("token")}`
        }
    });

};

export const saveWeather = (weather) =>{
   return api.post("/api/weather", weather, {
           headers: {
               Authorization: `Bearer ${localStorage.getItem("token")}`
           }
       });

   };