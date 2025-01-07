const fs = require('fs')
const path = require('path')

const files = fs.readdirSync(__dirname);

files.forEach((file) => {
    if (path.extname(file) == '.js') {
        fs.renameSync(file, file.replace('.js', '.jsx'));
        // console.log(file.replace('.js', '.jsx'))
    }
})