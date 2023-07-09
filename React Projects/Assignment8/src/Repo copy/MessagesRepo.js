import {workspacesContext} from '../Model/ViewModel';

export const GET = async (id) => {
    const {token, setResponse, response} = React.useContext(workspacesContext);
    await fetch('https://cse118.com/api/v2/channel/'+id+'/message', {
        method: 'GET',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer '+token,
        },
    })
    .then(response => {
        setResponse(response.status);
        return response.json();
    })
    .then(json => {
        if (response == 200) {
          setResponse("it worked");
        }
        return json;
    })
};