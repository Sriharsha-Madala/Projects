export const GET = async (token) => {
    console.log("line 5 get workspaces");
    console.log("line 6 token? " +token);
    // const {setResponse} = React.useContext(workspacesContext);
    await fetch('https://cse118.com/api/v2/workspace', {
        method: 'GET',
        headers: {
            Accept: 'application/json',
            // 'Content-Type': 'application/json',
            'Authorization': 'Bearer '+token,
        },
    })
    .then(response => {
        console.log("lione 17")
        if (response.status == 200) {
            return response.json();
        }
    })
    .then(json => {
        // if (response == 200) {
        //   setResponse("it worked");
        // }
        // else {
        //     setResponse("it did not work");
        // }
        console.log("this is the json "+json);
        console.log(json);
        resolve(json);
    })
    // await fetch('https://cse118.com/api/v2/login', {
    //     method: 'POST',
    //     headers: {
    //         Accept: 'application/json',
    //         'Content-Type': 'application/json',
    //     },
    //     body: JSON.stringify({
    //         email: "srmadala@ucsc.edu",
    //         password: "1755898",
    //     }),
    // })
    // .then(response => {
    //     setResponse(response.status);
    //     return response.json();
    // })
    // setResponse("problem?")
};
