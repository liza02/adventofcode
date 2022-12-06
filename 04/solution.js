const fs = require('fs');

function contains(container, content) {
    var containerInf = parseInt(container.split("-")[0])
    var containerSup = parseInt(container.split("-")[1])
    var contentInf = parseInt(content.split("-")[0])
    var contentSup = parseInt(content.split("-")[1])
    return containerInf <= contentInf && containerSup >= contentSup
}

function overlaps(sectX, sectY) {
    var sectXInf = parseInt(sectX.split("-")[0])
    var sectXSup = parseInt(sectX.split("-")[1])
    var sectYInf = parseInt(sectY.split("-")[0])
    var sectYSup = parseInt(sectY.split("-")[1])
    return (sectYInf <= sectXSup && sectXSup <= sectYSup) || (sectYInf <= sectXInf && sectXInf <= sectYSup)
}

function testRelationInPair(pair, callback) {
    pair = pair.split(",")
    return callback(pair[0], pair[1]) || callback(pair[1], pair[0])
}

fs.readFile('04/input.txt', 'utf8', (err, pairs) => {
    if (err) {
        console.error(err);
        return;
    }
    pairs = pairs.split("\n").filter(element => element)
    pairsWhereOneRangeFullyContainsOther = pairs.filter( (pair) => testRelationInPair(pair, contains))
    console.log("assignment pairs where one range fully contains the other : " + pairsWhereOneRangeFullyContainsOther.length)
    pairsOverlapsing = pairs.filter((pair) => testRelationInPair(pair, overlaps) || testRelationInPair(pair, contains))
    console.log("assignment pairs that overlaps the ranges : " + pairsOverlapsing.length)
});
