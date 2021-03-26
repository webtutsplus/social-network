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

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
