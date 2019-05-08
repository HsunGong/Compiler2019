# Main Function
		global		main
		extern		malloc

		section		.text

# function _init_func

__b__init_func_entry_1:
		push		rbx
		push		rbp
		sub		rsp, 8
		mov		rbp, rsp
		add		rsp, 8
		pop		rbp
		pop		rbx
		ret

# function main

main:
		push		rbx
		push		rbp
		sub		rsp, 8
		mov		rbp, rsp
		call		__b__init_func_entry_1
		mov		r10, __d_sta_str_1
		push		r9
		push		r10
		mov		rdi, r10
		mov		rsi, r10
		call		__builtin_string_concat
		pop		r10
		pop		r9
		mov		r9, rax
		push		r9
		push		r10
		mov		rdi, r9
		call		_Z7printlnPc
		pop		r10
		pop		r9
		push		r9
		push		r10
		mov		rdi, r10
		mov		rsi, r10
		call		__builtin_string_concat
		pop		r10
		pop		r9
		mov		r10, rax
		push		r9
		push		r10
		mov		rdi, r9
		mov		rsi, r10
		call		__builtin_string_equal
		pop		r10
		pop		r9
		mov		r9, rax
		cmp		r9, 1
		je		__b_if_then_1
		jmp		__b_if_after_1
__b_if_then_1:
		push		r9
		push		r10
		mov		rdi, __d_sta_str_2
		call		_Z7printlnPc
		pop		r10
		pop		r9
__b_if_after_1:
		mov		rax, 0
		add		rsp, 8
		pop		rbp
		pop		rbx
		ret


		section		.data
__d_sta_str_3:
		dq		0
		db		0
__d_sta_str_2:
		dq		5
		db		104, 101, 108, 108, 111, 0
__d_sta_str_1:
		dq		7
		db		97, 98, 99, 100, 101, 102, 103, 0

