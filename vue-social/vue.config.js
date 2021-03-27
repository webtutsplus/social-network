const fs = require('fs');

module.exports = {
    devServer: {
        disableHostCheck: true,
	port: 443,
        https: {
		key: fs.readFileSync('/etc/letsencrypt/live/socialmediaorganiser.com-0002/privkey.pem'),
		cert:  fs.readFileSync('/etc/letsencrypt/live/socialmediaorganiser.com-0002/fullchain.pem')
	},
        public: '0.0.0.0:443'
    }
}

