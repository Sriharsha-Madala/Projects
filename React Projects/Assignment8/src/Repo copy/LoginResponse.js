import workspaces from '../Resources/Workspaces.json';
import {workspacesContext} from '../Model/ViewModel';

export const GET = async (navigation, user, pass) => {
    const {setloggedIn, setToken, setloginID, setResponse} = React.useContext(workspacesContext);
    await fetch('https://cse118.com/api/v2/login', {
        method: 'POST',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            email: user,
            password: pass,
        }),
    })
    .then(response => {
        setResponse(response.status);
        return response.json();
    })
    .then(async json => {
        if (response == 200) {
            setToken(json.accessToken);
            setloginID(json.id);
            setloggedIn(true);
            navigation.navigate('Workspaces', {title: "Workspaces"});
        }
    })
};