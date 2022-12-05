const fs = require('fs');

function contains(container, content) {
    var container_inf = parseInt(container.split("-")[0])
    var container_sup = parseInt(container.split("-")[1])
    var content_inf = parseInt(content.split("-")[0])
    var content_sup = parseInt(content.split("-")[1])
    return container_inf <= content_inf && container_sup >= content_sup
}

function overlaps(sectX, sectY) {
    var sectX_inf = parseInt(sectX.split("-")[0])
    var sectX_sup = parseInt(sectX.split("-")[1])
    var sectY_inf = parseInt(sectY.split("-")[0])
    var sectY_sup = parseInt(sectY.split("-")[1])
    return (sectY_inf <= sectX_sup && sectX_sup <= sectY_sup) || (sectY_inf <= sectX_inf && sectX_inf <= sectY_sup)
}

function test_relation_in_pair(pair, callback) {
    pair = pair.split(",")
    return callback(pair[0], pair[1]) || callback(pair[1], pair[0])
}

fs.readFile('04/input.txt', 'utf8', (err, pairs) => {
    if (err) {
        console.error(err);
        return;
    }
    pairs = pairs.split("\n").filter(element => element)
    pairs_where_one_range_fully_contains_other = pairs.filter( (pair) => test_relation_in_pair(pair, contains))
    console.log("assignment pairs where one range fully contains the other : " + pairs_where_one_range_fully_contains_other.length)
    pairs_overlapsing = pairs.filter((pair) => test_relation_in_pair(pair, overlaps) || test_relation_in_pair(pair, contains))
    console.log("assignment pairs that overlaps the ranges : " + pairs_overlapsing.length)
});
