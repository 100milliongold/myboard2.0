// tools/production.js

const merge = require("webpack-merge");
const config = require("./base.config");

module.exports = merge.merge(config, {
  mode: "production",
});
