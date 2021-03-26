# vue-social

## Project setup
```
npm install
```

create a file frebase.js and copy the config file from firebase console

sample file 
```$xslt
import firebase from "firebase";

// Your web app's Firebase configuration
let firebaseConfig = {
    apiKey: "<apiKey>",
    authDomain: "social-login-ac5b2.firebaseapp.com",
    projectId: "social-login-ac5b2",
    storageBucket: "social-login-ac5b2.appspot.com",
    messagingSenderId: "",
    appId: "<app id>"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);
//abcdTest9&

```

### Deploy on server
* `ssh root@165.22.182.0`
* Go to social-network folder and vue-social
* create a file `.env` at the vue.js project root and add `VUE_APP_API_BASE_URL = http://165.22.182.0:8080/`
* Update the GitHub Code 
* To deploy the frontend,  
    * `ps -ef | grep "node"`
    * Kill the process that running vue-cli-service
    * `nohup npm run prod &`
