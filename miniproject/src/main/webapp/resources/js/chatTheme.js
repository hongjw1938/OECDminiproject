
function Message(arg) {
        this.text = arg.text, this.message_side = arg.message_side;
        this.draw = function (_this) {
            return function () {
                var $message;
                $message = $($('.message_template').clone().html());
                $message.addClass(_this.message_side).find('.text').html(_this.text);
                $('.messages').append($message);
                return setTimeout(function () {
                    return $message.addClass('appeared');
                }, 0);
            };
        }(this);
        return this;
};
function getMessageText() {
    let $message_input, message;
    let $messages = $('.messages');
    $message_input = $('.message_input');
    let isay = $message_input.val();
    $('.message_input').val('');
    message = new Message({
    	text: isay,
    	message_side : 'right'
    });
    message.draw();
    ajax_process(isay);
    return $messages.animate({ scrollTop: $messages.prop('scrollHeight') }, 300);
};
/*function sendMessage(text) {
    let $messages, message;
    
    //watson에 값을 보낸다.
    ajax_process(text);
    
    $('.message_input').val('');
    $messages = $('.messages');
    message_side = 'right';
    message = new Message({
        text: text,
        message_side: message_side
    });
    if(text != ''){
    	message.draw();
    }
    
    return $messages.animate({ scrollTop: $messages.prop('scrollHeight') }, 300);
};*/



$(document).ready(function(){
	
	$('.message_input').keyup(function(e){
		if(e.which === 13){
			getMessageText();
		}
	})
	
	$('.send_message').click(function(){
		getMessageText();
	})
	
	ajax_process('');
})
function ajax_process(_isay){
	$.ajax({
		
		type:'POST',
		url : 'watsonsay',
		data : {'isay':_isay},
		success: function(data){
			let messageSide = 'right' ? 'left' : 'right';
			let $messages = $('.messages');
			message = new Message({
				
				text: data.output.text,
				message_side : 'left'
			});
			message.draw();
			return $messages.animate({ scrollTop: $messages.prop('scrollHeight') }, 300);
				
		}
	});
	
}
