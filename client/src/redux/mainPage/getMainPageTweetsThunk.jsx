import {GET_TWEETS_MAIN_REQUEST, GET_TWEETS_MAIN_SUCCESS, GET_MAIN_ERROR  } from '../actions';
import axios from 'axios';



export const getMainPageTweetsThunk = () => {
    return (dispatch) => {
      dispatch({ type: GET_TWEETS_MAIN_REQUEST });
  
      axios.get(`https://twitter-clone-application.herokuapp.com/tweets/tweet/all/notauth`)
        .then((response) => {
            console.log(response.data.listDto);
          dispatch({type:GET_TWEETS_MAIN_SUCCESS,payload:{tweets: response.data.listDto}});
        })
        .catch((error) => {
            console.log(error);
          dispatch({ type: GET_MAIN_ERROR });
        });
    };
  };