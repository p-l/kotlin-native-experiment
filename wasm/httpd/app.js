const express = require('express')
const morgan = require('morgan')
const favicon = require('express-blank-favicon')

// Force content-type to wasm
// ref: https://github.com/expressjs/express/issues/3589
// remove line when express@^4.17
express.static.mime.types["wasm"] = "application/wasm";

// Configuration
server_port = process.env.PORT || process.argv[3] || 8000;
server_root = process.argv[2] || '.'
 
// Load the server
const app = express()
app.use(morgan('dev'))
app.use(favicon)
app.use('/', express.static(server_root));
app.listen(server_port, function () {
     console.log('httpd is up');
     console.log('    port: ' + server_port)
     console.log('    root: ' + server_root)
});