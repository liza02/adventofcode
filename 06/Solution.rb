require 'set'

file = File.open("./input.txt")
input = file.read

def check_marker (input, number_of_chars)
  chars = input.split('')
  chars.length.times do |i|
    potential_marker = input[i..i+number_of_chars-1]
    set = potential_marker.split('').to_set
    if set.length == number_of_chars
      puts "First marker after char %d" % (i+number_of_chars)
      break
    end
  end
end

puts "Part one :"
check_marker(input, 4)
puts "Part two :"
check_marker(input, 14)